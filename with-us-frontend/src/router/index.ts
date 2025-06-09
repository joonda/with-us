import {createRouter, createWebHistory} from 'vue-router'
import MainView from "../views/MainView.vue";
import FindEventsView from "../views/FindEventsView.vue";
import FindCompanion from "../views/FindCompanion.vue";
import MakeCompanion from "../views/MakeCompanion.vue";
import LoginView from "../views/LoginView.vue";
import SignUpView from "../views/SignUpView.vue";

const routes = [
    {path: '/', component: MainView, name: 'Home'},
    {path: '/events', component: FindEventsView, name: 'Events'},
    {path: '/events/:id', component: MakeCompanion, name: 'Making', props: true}, // ✅ 요 부분!
    {path: '/finds', component: FindCompanion, name: 'Finds'},
    {path: '/login', component: LoginView, name: 'Login'},
    {path: '/signup', component: SignUpView, name: 'Signup'},
]

const router = createRouter({
    history: createWebHistory('/'),
    routes,
})

export default router