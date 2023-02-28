<template>
  <div class="flex justify-center mt-4">
    <div class="flex items-center justify-center">
      <span
        class="text-white text-lg bg-sky-700 font-bold px-4 py-2 rounded-full"
        >{{ cost }}</span
      >
    </div>
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

  <div class="mt-8 flex flex-col items-center">
    <button @click="startGame">Start</button>
    <button @click="stopGame">Stop</button>
  </div>
</template>

<script setup>
import VerticalLine from "./VerticalLine";
import CharacterCard from "./CharacterCard";
import { ADD_COST, CLICK_CARD, MAX_VALUE, UNIT_VALUE } from "../store.js";
import { useStore } from "vuex";
import { computed, ref } from "vue";

const { state, commit } = useStore();
const speedFactor = [0.2, 1.0, 1.3, 1.7];
const regen = 420;
const constIdx = [...Array(11).keys()];

let timeInterval;
const speed = ref(1);
const isAuto = ref(false);
const autoIdx = ref(0);

//let isBullet = false;

const cards = computed(() => {
  return state.orders.slice(0, 3).map((i) => state.cards[i]);
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
      console.log(state.cards[state.orders[autoIdx.value]].cost);
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
