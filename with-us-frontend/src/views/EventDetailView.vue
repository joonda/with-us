<template>
  <div v-if="eventDetails">
    <h2>{{ eventDetails.title }}</h2>
  </div>
  <div v-else>
    <p>이벤트 정보를 불러오는 중입니다...</p>
  </div>
</template>
<script setup lang="ts">
import {onMounted, ref} from 'vue'
import { useRoute } from 'vue-router'
import axiosInstance from '../lib/axios'

const route = useRoute()
const eventId = route.params.id

interface EventDetails {
  title: string
  eventId: number
  place: string
  startDate: Date
  endDate: Date
  description: string
  organizer: string
}

const eventDetails = ref<EventDetails | null>(null)

onMounted(async () => {
  try {
    const res = await axiosInstance.get(`/api/events/${eventId}`)
    console.log(res.data)
    eventDetails.value = res.data
  } catch (err) {
    console.error('이벤트 상세 정보 불러오기 실패', err)
  }
})
</script>