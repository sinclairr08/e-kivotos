<template>
  <div
    class="absolute h-6 border-l-[1px] border-solid border-white"
    :style="[`left: ${location}px`]"
  />
</template>

<script setup>
import { defineProps, computed } from "vue";

const props = defineProps({
  idx: Number,
});
const location = computed(() => {
  return props.idx * 50;
});
</script>
