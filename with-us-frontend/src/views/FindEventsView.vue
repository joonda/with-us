<!--
  행사 이벤트 찾기
  Last Update: 25.06.12
-->

<template>
  <div class="max-w-5xl mx-auto">
    <p class="p-4 text-center text-3xl font-bold">행사 목록</p>

    <ul class="grid grid-cols-3 gap-x-10 gap-y-6">
      <li v-for="event in events" :key="event.eventId as number">
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

const events = ref<EventInfo[]>([])

onMounted(async () => {
  try {
    const res = await axiosInstance.get('/api/events')
    console.log(res.data)
    events.value = res.data
  } catch (err) {
    console.error('이벤트 불러오기 실패', err)
  }
})
</script>