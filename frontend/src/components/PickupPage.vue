<template>
  <div class="flex flex-col items-center space-y-4 mt-16">
    <div
      class="border-2 rounded-md border-gray-700 flex w-3/4 p-3 space-x-4"
      v-for="update in updates"
      :key="update.startDate"
    >
      <span> {{ update.startDate }} ~ {{ update.endDate }} </span>
      <span
        v-for="name in update.names"
        :key="name"
        class="border-l-2 border-gray-400 pl-4"
      >
        {{ name }}
      </span>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
import { CHANGE_STATUS } from "@/store";
import { useStore } from "vuex";

const { commit } = useStore();
const router = useRouter();
const updates = ref({});

onMounted(async () => {
  try {
    const { data } = await axios.get("/api/pickups");
    updates.value = data;
  } catch (err) {
    commit(CHANGE_STATUS, {
      code: err.response.status,
      message: err.response.statusText,
    });
    await router.push("/errors");
  }
});
</script>
