<template>
  <MainPage />
  <FooterComponent />
</template>

<script>
import MainPage from "./components/MainPage";
import FooterComponent from "./components/FooterComponent";

export default {
  name: "App",
  components: {
    MainPage,
    FooterComponent,
  },
};
</script>

<style></style>
