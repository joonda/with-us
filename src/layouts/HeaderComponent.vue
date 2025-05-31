<template>
  <nav class="w-full flex justify-center shadow-md">
    <div class="flex justify-between max-w-7xl w-full p-4 items-center">
      <div class="text-lg font-bold w-28">
        <RouterLink to="/">WITHUS</RouterLink>
      </div>
      <div class="flex items-center space-x-4 font-bold">
        <RouterLink to="/events">행사 찾기</RouterLink>
        <RouterLink to="/finds">동행 찾기</RouterLink>
        <RouterLink to="/making">동행 만들기</RouterLink>
      </div>
      <div class="flex items-center space-x-4 text-sm text-gray-400 w-28">
        <RouterLink to="/signup" class="hover:text-gray-500 transition">회원가입</RouterLink>
        <RouterLink to="/login" class="hover:text-gray-500 transition">로그인</RouterLink>
      </div>
    </div>
  </nav>
</template>

<script setup lang="ts">


</script>


<style scoped>
</style>
