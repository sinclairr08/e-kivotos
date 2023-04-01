import { createRouter, createWebHistory } from "vue-router";
import CostPage from "../components/CostPage";
import MainPage from "../components/MainPage";

export default new createRouter({
  history: createWebHistory("/e-kivotos"),
  routes: [
    { path: "/", component: MainPage },
    { path: "/cost", component: CostPage },
  ],
});
