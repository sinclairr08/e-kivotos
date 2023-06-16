<template>
  <div class="flex flex-col items-center space-y-4 mt-16">
    <div class="flex space-x-4">
      <button
        v-for="(name, i) in names"
        :key="i"
        @click="selectName(i)"
        :class="isSelected(i) + ' border-2 border-gray-400 p-2 rounded-md h-16'"
      >
        <div v-if="name === '상시'">상시 모집</div>
        <div v-else class="flex flex-col">
          <span>픽업 모집</span>
          <span class="text-xs">{{ name }}</span>
        </div>
      </button>
    </div>
    <div class="grid grid-cols-5 w-1/2">
      <div
        v-for="(result, idx) in resultData"
        :key="idx"
        :class="getCardStyle(result.star) + ' text-center m-2 py-1/4 text-sm'"
      >
        {{ currentState != "결과 확인" ? result.name : "★" }}
      </div>
    </div>
    <div class="flex justify-center space-x-4">
      <button
        class="p-2 bg-sky-400 rounded-md font-bold text-gray-900"
        @click="doRecruit"
      >
        {{ currentState }}
      </button>
      <button
        v-if="currentIdx !== 0"
        class="p-2 bg-sky-400 rounded-md font-bold text-gray-900"
        @click="repeatRecruit"
      >
        {{ currentRepeatState }}
      </button>
    </div>
    <div>모집 포인트: {{ pickupCount }}</div>
    <div>
      {{ message }}
    </div>
  </div>
</template>

<script setup>
import { onBeforeUnmount, onMounted, ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
import { CHANGE_STATUS } from "@/store";
import { useStore } from "vuex";

let selectedData = [];
let timeouts = [];
let fetchedData;
let allProb = [];
let finalProb = [];

const currentIdx = ref(0);
const pickupCount = ref(0);
const names = ref([]);
const currentState = ref("모집하기");
const currentRepeatState = ref("뽑을 때 까지 모집");
const resultData = ref([]);
const message = ref("Loading...");

const { commit } = useStore();
const router = useRouter();

const getCardStyle = (star) => {
  if (star === 1) return "bg-blue-300";
  if (star === 2) return "bg-yellow-300";
  else return "bg-purple-300";
};

const isSelected = (i) => {
  if (currentIdx.value === i) {
    return "bg-yellow-200";
  }
  return "";
};

const selectName = (i) => {
  allProb = fetchedData[i].allProb;
  finalProb = fetchedData[i].finalProb;
  currentIdx.value = i;
};

const doRecruit = () => {
  if (currentState.value == "결과 확인") {
    currentState.value = "한 번 더!";
  } else {
    currentState.value = "결과 확인";
    startRecruit();
  }
};

const repeatRecruit = () => {
  if (currentRepeatState.value === "뽑을 때 까지 모집") {
    currentRepeatState.value = "뽑는 중";
    startRepeatRecruit(fetchedData[currentIdx.value].pickupName);
    currentRepeatState.value = "뽑기 완료! (다시 하기)";
  } else if (currentRepeatState.value === "뽑기 완료! (다시 하기)") {
    currentRepeatState.value = "뽑을 때 까지 모집";
    pickupCount.value = 0;
  }
};

const startRepeatRecruit = (name) => {
  let returnData = startRecruit();

  while (
    !returnData.map((r) => r.name).includes(name) &&
    pickupCount.value < 200
  ) {
    returnData = startRecruit();
  }
};

const clearTimeouts = () => {
  timeouts.forEach((t) => clearTimeout(t));
};

const startRecruit = () => {
  clearTimeouts();
  resultData.value = [];
  selectedData = selectData();

  for (let i = 0; i < 10; i++) {
    timeouts[i] = setTimeout(() => {
      resultData.value.push(selectedData[i]);
    }, (i + 1) * 75);
  }

  return selectedData;
};

const selectData = () => {
  return Array(10)
    .fill(0)
    .map((_, i) => select(i));
};

const select = (i) => {
  pickupCount.value++;
  const prob = i === 9 ? finalProb : allProb;
  const curProb = Math.random() * 100;
  let idx = 0;

  while (curProb > prob[idx].prob) {
    idx++;
  }

  return prob[idx];
};

onMounted(async () => {
  try {
    const { data } = await axios.get("/api/recruit");
    fetchedData = data;
    names.value = fetchedData.map((i) =>
      i.pickupName ? i.pickupName : "상시"
    );
    selectName(0);
    message.value = "";
  } catch (err) {
    commit(CHANGE_STATUS, {
      code: err.response.status,
      message: err.response.statusText,
    });
    await router.push("/errors");
  }
});

onBeforeUnmount(() => {
  clearTimeouts();
});
</script>
