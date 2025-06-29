<!--
  ===========================================
  최초작성자    : 이현준
  최초작성일    : 25.06.13.
  수정자       : 이현준
  마지막 수정일 : 25.06.29.
  설명        : 동행 찾기 페이지
  수정내용     : 로그인 상태가 아닐 시, 강제로 login 화면으로 push 추가
  ===========================================
-->

<template>
  <div class="max-w-5xl mx-auto">
    <p class="p-4 text-center text-3xl font-bold">행사 목록</p>

    <ul class="grid grid-cols-3 gap-x-10 gap-y-6">
      <li v-for="event in events" :key="event.eventId">
        <EventCard :event="event" />
      </li>
    </ul>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import EventCard from '../components/EventCard.vue'
import axiosInstance from "../lib/axios.ts";
import type {EventInfo} from "../types/types.ts"
import {useRouter} from "vue-router";

const events = ref<EventInfo[]>([])
const router = useRouter()

onMounted(async () => {
  try {

    const token = localStorage.getItem('token');

    const res = await axiosInstance.get('/api/events',
        { headers: {
          Authorization: `Bearer ${token}`
          }
        })
    console.log(res.data)
    events.value = res.data
  } catch (err) {
    console.error('이벤트 불러오기 실패', err)
    await router.push('/login')
  }
})
</script>