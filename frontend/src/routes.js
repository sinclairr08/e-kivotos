import { createRouter, createWebHistory } from "vue-router";
import CostPage from "./components/CostPage.vue";
import MainPage from "./components/MainPage.vue";
import VersionPage from "./components/VersionPage.vue";
import NotFound from "@/views/NotFound.vue";
import AdminV from "@/views/AdminV.vue";

export default new createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: [
    { path: "/", component: MainPage },
    { path: "/cost", component: CostPage },
    { path: "/versions", component: VersionPage },
    { path: "/admin/v", component: AdminV },
    { path: "/notFound", component: NotFound },
    { path: "/:pathMatch(.*)*", redirect: "/notFound" },
  ],
});
