<!--
  동행 만들기 페이지
  Last Update: 25.06.12
-->

<template>
  <div class="w-full max-w-3xl mx-auto p-4">
    <h1 class="text-2xl font-bold mb-4">동행 만들기</h1>
    <form>
      <!-- 제목 -->
      <div class="mb-4">
        <label class="block font-semibold mb-1">제목</label>
        <input type="text" class="w-full border rounded p-2" placeholder="제목을 입력하세요" />
      </div>

      <!-- 설명 -->
      <div class="mb-4">
        <label class="block font-semibold mb-1">설명</label>
        <textarea class="w-full border rounded p-2" rows="4" placeholder="어떤 동행인지 설명해 주세요"></textarea>
      </div>

      <!-- 모집 마감일 -->
      <div class="mb-4">
        <label class="block font-semibold mb-1">모집 마감일</label>
        <input type="date" class="w-full border rounded p-2" />
      </div>

      <!-- 최대 인원 -->
      <div class="mb-4">
        <label class="block font-semibold mb-1">최대 인원</label>
        <input type="number" class="w-full border rounded p-2" min="2" />
      </div>

      <!-- 만남 장소 -->
      <div class="mb-4">
        <label class="block font-semibold mb-1">만남 장소</label>
        <input type="text" class="w-full border rounded p-2" />
      </div>

      <!-- 기타 정보 -->
      <div class="mb-4">
        <label class="block font-semibold mb-1">기타 정보</label>
        <textarea class="w-full border rounded p-2" rows="3" placeholder="공유할 추가 정보가 있다면 입력하세요"></textarea>
      </div>

      <!-- 제출 버튼 -->
      <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">
        동행 모집 등록
      </button>
    </form>
  </div>
</template>
<script setup lang="ts">
import {useRoute} from "vue-router";

const route = useRoute()
const eventId = route.params.id as string

</script>