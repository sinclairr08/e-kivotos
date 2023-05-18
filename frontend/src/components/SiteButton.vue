<template>
  <div
    class="text-center p-2 m-2 border-gray-500 border-2 rounded-lg shadow w-48"
  >
    <a :href="siteUrl" class="flex flex-col items-center space-y-1.5">
      <img :src="siteThumbnailUrl" class="w-16 h-16" />
      <span class="mt-12 font-bold text-sm">
        {{ name }}
      </span>
    </a>
  </div>
</template>

<script setup>
import { defineProps } from "vue";

defineProps({
  name: String,
  siteUrl: String,
  siteThumbnailUrl: String,
});
</script>
