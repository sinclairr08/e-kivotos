<template>
  <form @submit.prevent="submitForm">
    <div class="flex flex-col space-y-2 ml-8 mt-16">
      <div class="flex items-center">
        <label class="w-32"> Version </label>
        <input v-model="versionString" class="border-black border" />
      </div>
      <div class="flex items-center">
        <label class="w-32"> Date </label>
        <input v-model="releaseDate" class="border-black border" />
      </div>
      <template v-for="(update, index) in updates" :key="index">
        <div class="flex items-center">
          <label class="w-32"> Update {{ index }} </label>
          <input v-model="updates[index]" class="border-black border" />
          <button
            class="ml-8 text-red-400"
            type="button"
            @click.stop.prevent="deleteUpdate(index)"
          >
            X
          </button>
        </div>
      </template>
      <div class="pt-2 w-64 flex justify-center">
        <button type="button" @click.stop.prevent="addUpdate">+</button>
      </div>
      <div class="w-64 flex justify-center">
        <button type="submit">Submit</button>
      </div>
    </div>
  </form>
</template>

<script setup>
import axios from "axios";
import { ref } from "vue";

const versionString = ref("");
const releaseDate = ref("");
const updates = ref([""]);

const submitForm = async () => {
  console.log({
    versionString: versionString.value,
    releaseDate: releaseDate.value,
    updates: [...updates.value],
  });
  await axios.post("/api/versions", {
    versionString: versionString.value,
    releaseDate: releaseDate.value,
    updates: [...updates.value],
  });

  versionString.value = "";
  releaseDate.value = "";
  updates.value = [""];
};

const addUpdate = () => {
  updates.value.push("");
};

const deleteUpdate = (i) => {
  if (updates.value.length > 1) {
    updates.value.splice(i, 1);
  }
};
</script>
