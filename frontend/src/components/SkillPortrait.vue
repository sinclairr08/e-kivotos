<template>
  <div><img :src="skillPortraitUrl(props.code)" /></div>
</template>

<script setup>
import { defineProps } from "vue";

const props = defineProps({
  code: String,
});

const skillPortraitUrl = (name) => {
  return require(`@/assets/skillPortraits/Skill_Portrait_${
    name ? name : "Error"
  }.png`);
};
</script>
