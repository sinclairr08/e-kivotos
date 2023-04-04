<template>
  <button
    class="w-36 h-36 bg-gray-500 text-center flex flex-col items-center justify-center"
    @click="onClickCard"
  >
    <span class=""> {{ name }}</span>
    <span class=""> {{ cost }}</span>
  </button>
</template>

<script setup>
import { CLICK_CARD } from "@/store";
import { defineProps } from "vue";
import { useStore } from "vuex";

const { commit } = useStore();
const props = defineProps({
  name: String,
  cost: Number,
  idx: Number,
});

const onClickCard = () => {
  commit(CLICK_CARD, props.idx);
};
</script>
