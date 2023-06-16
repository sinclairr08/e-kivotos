<template>
  <div class="mt-16 flex flex-col space-y-4 items-center">
    <h1 class="font-bold">{{ code }} {{ message }}</h1>
    <h1>상단의 메인 버튼을 눌러 주세요</h1>
  </div>
</template>

<script setup>
import { useStore } from "vuex";
import { computed } from "vue";

const { state } = useStore();
const code = computed(() => state.statusCode);
const message = computed(() => state.statusMessage);
</script>
