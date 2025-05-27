import {createRouter, createWebHistory} from 'vue-router'
import MainView from "../views/MainView.vue";
import FindEventsView from "../views/FindEventsView.vue";
import FindCompanion from "../views/FindCompanion.vue";
import MakeCompanion from "../views/MakeCompanion.vue";

const routes = [
    {path: '/', component: MainView, name: 'Home'},
    {path: '/events', component: FindEventsView, name: 'Events'},
    {path: '/finds', component: FindCompanion, name: 'Finds'},
    {path: '/making', component: MakeCompanion, name: 'Making'}
]

const router = createRouter({
    history: createWebHistory('/'),
    routes,
})

export default router