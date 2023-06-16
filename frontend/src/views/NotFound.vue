<template>
  <div>처리중</div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { onMounted } from "vue";
import { useStore } from "vuex";
import { CHANGE_STATUS } from "@/store";

const { commit } = useStore();
const router = useRouter();

onMounted(() => {
  commit(CHANGE_STATUS, { code: 404, message: "Not Found" });
  router.push("/errors");
});
</script>
