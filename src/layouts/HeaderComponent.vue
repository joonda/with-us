<template>
  <nav class="w-full flex justify-center shadow-md">
    <div class="flex justify-between max-w-7xl w-full p-4 items-center">
      <div>
        <RouterLink to="/">Home</RouterLink>
      </div>
      <div class="flex items-center space-x-4">
        <RouterLink to="/events">행사 찾기</RouterLink>
        <RouterLink to="/finds">동행 찾기</RouterLink>
        <RouterLink to="/making">동행 만들기</RouterLink>
      </div>
      <div class="flex items-center space-x-4">
        <p>회원가입</p>
        <p>로그인</p>
      </div>
    </div>
  </nav>
</template>

<script setup lang="ts">


</script>


<style scoped>
</style>
