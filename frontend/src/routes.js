import { createRouter, createWebHistory } from "vue-router";
import CostPage from "./components/CostPage.vue";
import MainPage from "./components/MainPage.vue";
import VersionPage from "./components/VersionPage.vue";
import RecruitPage from "@/components/RecruitPage.vue";
import PickupPage from "@/components/PickupPage.vue";
import ErrorPage from "@/views/ErrorPage.vue";
import NotFound from "@/views/NotFound.vue";

export default new createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: [
    { path: "/", component: MainPage },
    { path: "/cost", component: CostPage },
    { path: "/versions", component: VersionPage },
    { path: "/recruit", component: RecruitPage },
    { path: "/pickups", component: PickupPage },
    { path: "/notFound", component: NotFound },
    { path: "/errors", component: ErrorPage },
    { path: "/:pathMatch(.*)*", redirect: "/notFound" },
  ],
});
