<template>
  <HeaderComponent />
  <div class="mt-12 mb-20">
    <router-view />
  </div>
  <FooterComponent />
</template>

<script setup>
import HeaderComponent from "@/components/HeaderComponent";
import FooterComponent from "@/components/FooterComponent";
</script>
