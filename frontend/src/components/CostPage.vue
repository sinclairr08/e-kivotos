<template>
  <div class="flex flex-col items-center justify-center mt-16">
    <div class="flex items-center justify-center">
      <span
        class="text-white text-lg bg-sky-700 font-bold h-12 w-12 rounded-full flex items-center justify-center"
        >{{ cost }}
      </span>
      <div class="flex flex-col items-center justify-center">
        <div class="flex space-x-2 mt-2">
          <CharacterCard
            v-for="(card, i) in cards"
            :key="card.name"
            :idx="i"
            v-bind="card"
          />
        </div>
        <div class="mt-2 h-6 w-[500px] relative bg-sky-900">
          <div
            class="absolute h-6 bg-sky-400"
            :style="[`width: ${percentage}`]"
          ></div>
          <VerticalLine v-for="i in constIdx" :key="i" :idx="i" />
        </div>
      </div>
      <div class="flex flex-col justify-center ml-2 mt-2">
        <button
          :class="
            speedButtonStyle + 'w-24 rounded text-lg py-0.5 text-center mb-0.5'
          "
          @click="toggleSpeed"
        >
          {{ speedButtonString }}
        </button>
        <button
          :class="
            autoButtonStyle +
            'w-24 text-center rounded text-lg py-0.5 mt-0.5 font-bold'
          "
          @click="toggleAuto"
        >
          AUTO
        </button>
      </div>
    </div>
    <button class="mt-8" @click="startGame">시작</button>
    <button class="mt-2" @click="stopGame">일시 정지</button>

    <div class="grid grid-cols-10 mt-6">
      <button
        v-for="(s, i) in student"
        :key="s.name"
        :class="
          (s.clicked ? 'border-red-600' : 'border-gray-900') +
          ' flex items-center justify-center text-xs m-0.5 border-2 border-gray-900 rounded-md px-0.5'
        "
        @click="clickStudent(i)"
      >
        <SkillPortrait v-bind="s" />
      </button>
    </div>
    <button class="mt-4" @click="selectStudent">학생 선택</button>

    <div class="mt-4">{{ message }}</div>
  </div>
</template>

<script setup>
import VerticalLine from "./VerticalLine";
import CharacterCard from "./CharacterCard";
import {
  ADD_COST,
  CHANGE_STATUS,
  CLICK_CARD,
  MAX_VALUE,
  UNIT_VALUE,
} from "../store.js";
import { useStore } from "vuex";
import { computed, onBeforeMount, ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
import SkillPortrait from "@/components/SkillPortrait.vue";

const { state, commit } = useStore();
const router = useRouter();
const speedFactor = [0.2, 1.0, 1.3, 1.7];
const regen = 420;
const constIdx = [...Array(11).keys()];

let timeInterval;
const student = ref([]);
const speed = ref(1);
const isAuto = ref(false);
const autoIdx = ref(0);
const message = ref("Loading...");

//let isBullet = false;

const cards = computed(() => {
  return state.cards.length == 6
    ? state.orders.slice(0, 3).map((i) => state.cards[i])
    : [];
});

const cost = computed(() => {
  return Math.floor(state.costValue / UNIT_VALUE);
});

const percentage = computed(() => {
  return (100 * state.costValue) / MAX_VALUE + "%";
});

const speedButtonString = computed(() => {
  return "▶".repeat(speed.value);
});

const speedButtonStyle = computed(() => {
  if (speed.value == 1) return "bg-gray-400 text-gray-700 ";
  if (speed.value == 2) return "bg-sky-400 text-sky-700 ";
  return "bg-yellow-400 text-yellow-700 ";
});

const autoButtonStyle = computed(() => {
  if (isAuto.value) {
    return "bg-yellow-400 text-yellow-700 ";
  }
  return "bg-gray-400 text-gray-700 ";
});

const clickStudent = (idx) => {
  student.value[idx] = {
    ...student.value[idx],
    clicked: !student.value[idx].clicked,
  };
};

const selectStudent = () => {
  let selected = student.value.filter((s) => s.clicked === true);
  if (selected.length != 6) {
    message.value = "6명을 선택하세요";
    state.cards = [];
    return;
  }
  state.cards = selected;
};

const startGame = () => {
  if (timeInterval) stopGame();

  timeInterval = setInterval(() => {
    commit(ADD_COST, { speed: speedFactor[speed.value], regen });
    if (
      isAuto.value &&
      state.costValue >=
        state.cards[state.orders[autoIdx.value]].cost * UNIT_VALUE
    ) {
      commit(CLICK_CARD, autoIdx.value);
      // console.log(state.cards[state.orders[autoIdx.value]].cost);
      autoIdx.value =
        autoIdx.value == 2 ? autoIdx.value - 2 : autoIdx.value + 1;
    }
  }, 100);
};

const stopGame = () => {
  clearInterval(timeInterval);
};

const toggleSpeed = () => {
  speed.value = speed.value == 3 ? speed.value - 2 : speed.value + 1;
};

const toggleAuto = () => {
  isAuto.value = !isAuto.value;
  if (isAuto.value) {
    autoIdx.value = 0;
  }
};

onBeforeMount(async () => {
  try {
    const { data } = await axios.get("/api/students/cost");
    student.value = data;
    message.value = "";
  } catch (err) {
    commit(CHANGE_STATUS, {
      code: err.response.status,
      message: err.response.statusText,
    });
    await router.push("/errors");
  }
});

// let prevTime, curTime;
//prevTime = new Date();
// regenCost() {
//   if (this.value < MAX_VALUE) {
//     curTime = new Date();
//     this.value += (curTime - prevTime) * 4.2;
//     prevTime = curTime;

//     this.value = this.value > MAX_VALUE ? MAX_VALUE : this.value;

//     costRegen = 420 * this.getSpeedFactor();

//     this.value =
//       this.value + costRegen > MAX_VALUE
//         ? MAX_VALUE
//         : this.value + costRegen;
//   }
// },
</script>
