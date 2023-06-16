<template>
  <div v-if="versions" class="flex flex-col border-b-2 border-purple-900">
    <div
      class="border-t-2 border-purple-900 p-4"
      v-for="version in versions"
      :key="version.versionString"
    >
      <div>
        <span>Ver. {{ version.versionString }}</span>
        <span class="ml-4 text-xs">{{ version.releaseDate }}</span>
      </div>
      <li v-for="update in version.updates" :key="update" class="ml-2">
        {{ update }}
      </li>
    </div>
  </div>
  <div v-if="message" class="flex justify-center mt-4">
    <span>{{ message }}</span>
  </div>
</template>

<script setup>
import axios from "axios";
import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { CHANGE_STATUS } from "@/store";
import { useStore } from "vuex";

const versions = ref({});
const message = ref("Loading...");
const { commit } = useStore();
const router = useRouter();

onMounted(async () => {
  try {
    const { data } = await axios.get(`/api/versions`);
    versions.value = data;
    message.value = "";
  } catch (err) {
    commit(CHANGE_STATUS, {
      code: err.response.status,
      message: err.response.statusText,
    });
    await router.push("/errors");
  }
});
</script>
