import { createRouter, createWebHistory } from "vue-router";
import CostPage from "./components/CostPage.vue";
import MainPage from "./components/MainPage.vue";
import VersionPage from "./components/VersionPage.vue";
import NotFound from "@/views/NotFound.vue";
import RecruitPage from "@/components/RecruitPage.vue";
import InternalServerError from "@/views/InternalServerError.vue";

export default new createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: [
    { path: "/", component: MainPage },
    { path: "/cost", component: CostPage },
    { path: "/versions", component: VersionPage },
    { path: "/recruit", component: RecruitPage },
    { path: "/404", component: NotFound },
    { path: "/500", component: InternalServerError },
    { path: "/:pathMatch(.*)*", redirect: "/404" },
  ],
});
