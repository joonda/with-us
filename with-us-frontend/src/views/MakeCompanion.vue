<template>
  <div v-if="eventDetails">
    <h2>{{ eventDetails.title }} 동행 만들기</h2>
    <!-- 동행 만들기 폼 여기 작성 -->
  </div>
  <div v-else>
    <p>이벤트 정보를 불러오는 중입니다...</p>
  </div>
</template>
<script setup lang="ts">
import { onMounted, ref } from 'vue'
import { useRoute } from 'vue-router'
import axiosInstance from '../lib/axios'

const route = useRoute()
const eventId = route.params.id

const eventDetails = ref(null)

onMounted(async () => {
  try {
    const res = await axiosInstance.get(`/api/events/${eventId}`)
    eventDetails.value = res.data
  } catch (err) {
    console.error('이벤트 상세 정보 불러오기 실패', err)
  }
})
</script>