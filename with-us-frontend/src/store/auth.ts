/*
* 로그인 상태 저장 관리
* Last Update: 25.06.08
* */

import {defineStore} from "pinia";

export const useUserStore = defineStore('user', {
    state: () => ({
        token: localStorage.getItem('token') || '',
    }),
    getters: {
        isLoggedIn: state => !!state.token,
    },
    actions: {
        login(token: string) {
            this.token = token
            localStorage.setItem('token', token)
        },
        logout() {
            if (confirm('로그아웃 하시겠습니까?')) {
                this.token = ''
                localStorage.removeItem('token')
                window.location.href = '/login'
            }
        }
    }
})