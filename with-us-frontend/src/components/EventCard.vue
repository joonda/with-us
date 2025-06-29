<!--
  ===========================================
  최초작성자    : 이현준
  최초작성일    : 25.06.09.
  수정자       : 이현준
  마지막 수정일 : 25.06.29.
  설명        : 행사 카드 컴포넌트
  수정내용     : props의 type 변경 (Date)
  ===========================================
-->

<template>
  <div class="w-76 h-auto cursor-pointer" @click="goToEventDetail">
    <!-- 이미지 경로를 DB에 저장하는 방법 고려  -->
    <img :src="`src/assets/cardimg/${event.eventId}.png`" :alt="`${event.title}`"/>
    <div class="p-1">
      <p class="text-lg font-bold">{{ event.title }}</p>
      <p class="text-sm">{{ event.startDate }} ~ {{ event.endDate }}</p>
      <p class="text-sm">{{ event.place }}</p>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'

const props = defineProps<{
  event: {
    eventId: number
    title: string
    startDate: Date
    endDate: Date
    place: string
  }
}>()

const router = useRouter()

function goToEventDetail() {
  router.push({ name: 'EventDetail', params: { id: props.event.eventId } })
}
</script>