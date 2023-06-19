<template>
  <button
    class="w-36 h-36 text-center flex flex-col items-center justify-center"
    @click="onClickCard"
  >
    <div class="relative">
      <span
        class="absolute top-1 right-4 text-white w-8 h-8 border-2 border-gray-800 bg-sky-500 rounded-full flex items-center justify-center"
      >
        {{ cost }}
      </span>
      <SkillPortrait v-bind="{ code }" />
    </div>
  </button>
</template>

<script setup>
import { CLICK_CARD } from "@/store";
import { defineProps } from "vue";
import { useStore } from "vuex";
import SkillPortrait from "@/components/SkillPortrait.vue";

const { commit } = useStore();
const props = defineProps({
  name: String,
  code: String,
  cost: Number,
  idx: Number,
});

const onClickCard = () => {
  commit(CLICK_CARD, props.idx);
};
</script>
