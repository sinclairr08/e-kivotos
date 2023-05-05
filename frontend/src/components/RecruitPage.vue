<template>
  <div class="flex flex-col items-center space-y-4 mt-16">
    <div class="text-xl font-bold">상시 모집</div>
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
    </div>
    <div>
      {{ message }}
    </div>
  </div>
</template>

<script setup>
import { onBeforeUnmount, onMounted, ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

let selectedData = [];
let timeouts = [];
let allData;
let overData;

const currentState = ref("모집하기");
const resultData = ref([]);
const message = ref("Loading...");

const router = useRouter();

const getCardStyle = (star) => {
  if (star == 1) return "bg-blue-300";
  if (star == 2) return "bg-yellow-300";
  else return "bg-purple-300";
};

const doRecruit = () => {
  if (currentState.value == "결과 확인") {
    currentState.value = "한 번 더!";
  } else {
    currentState.value = "결과 확인";
    startRecruit();
  }
};

const startRecruit = () => {
  resultData.value = [];
  selectedData = selectData();

  for (let i = 0; i < 10; i++) {
    timeouts[i] = setTimeout(() => {
      resultData.value.push(selectedData[i]);
    }, (i + 1) * 200);
  }
};

const selectData = () => {
  return Array(10)
    .fill(0)
    .map((_, i) => select(i));
};

const select = (i) => {
  const data = i == 9 ? overData : allData;
  const curProb = Math.random() * 100;
  let idx = 0;

  while (curProb > data[idx].prob) {
    idx++;
  }

  return data[idx];
};

const fetchData = async () => {
  let fetched;
  try {
    const { data } = await axios.get("/api/students/recruit");
    fetched = data;
    message.value = "";
  } catch (err) {
    if (err.response.status === 500) {
      await router.push("/500");
    } else {
      message.value = err.response.status.toString();
    }
  }

  const cnt = [0, 0, 0, 0];

  for (let i = 0; i < fetched.length; i++) {
    cnt[fetched[i].star]++;
  }

  const allPercentage = [0, 78.5, 18.5, 3];
  const overPercentage = [0, 0, 97, 3];

  for (let i = 1; i <= 3; i++) {
    allPercentage[i] /= cnt[i];
    overPercentage[i] /= cnt[i];
  }

  let prob = 0.0;
  const all = fetched.map((data) => {
    prob += allPercentage[data.star];
    return { ...data, prob };
  });

  prob = 0.0;

  const over = fetched
    .filter((data) => data.star > 1)
    .map((data) => {
      prob += overPercentage[data.star];
      return { ...data, prob };
    });

  return [all, over];
};

onMounted(async () => {
  [allData, overData] = await fetchData();
});

onBeforeUnmount(() => {
  timeouts.forEach((t) => clearTimeout(t));
});
</script>
