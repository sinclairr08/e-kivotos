import { createRouter, createWebHashHistory } from "vue-router";
import CostPage from "./components/CostPage.vue";
import MainPage from "./components/MainPage.vue";
import VersionPage from "./components/VersionPage.vue";

export default new createRouter({
  history: createWebHashHistory("/e-kivotos"),
  routes: [
    { path: "/", component: MainPage },
    { path: "/cost", component: CostPage },
    { path: "/versions", component: VersionPage },
  ],
});
