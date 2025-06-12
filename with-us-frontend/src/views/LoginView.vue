<!--
  로그인 페이지
  Last Update: 25.06.12
-->
<template>
  <div>
    <p class="p-4 text-center text-2xl font-bold">함께하는 행사,<br/>WITHUS와 시작하세요</p>
    <form @submit.prevent="handleLogin" class="mt-12 w-lg grid grid-cols-1 gap-6 text-sm">
      <div>
        <label for="identify" class="block mb-1">아이디(이메일)</label>
        <input v-model="form.identify"
               id="identify"
               type="email"
               class="p-4 w-full border border-gray-300 rounded-md"
               placeholder="E-mail을 입력해주세요."
               required
               :disabled="loading"
        />
      </div>
      <div>
        <label for="password" class="block mb-1">비밀번호</label>
        <input v-model="form.password"
               id="password"
               type="password"
               class="p-4 w-full border border-gray-300 rounded-md"
               placeholder="비밀번호를 입력해주세요."
               required
               :disabled="loading"
        />
      </div>

      <div v-if="error" class="text-red-500 text-sm bg-red-50 p-3 rounded-md">
        {{ error }}
      </div>

      <button
          type="submit"
          class="mt-2 bg-[#569AFF] py-4 rounded-lg cursor-pointer hover:bg-[#4383e0] transition text-white"
          :disabled="loading"
      >
        {{ loading ? '로그인 중...' : '로그인' }}
      </button>
      <ul class="flex justify-center divide-x text-gray-500 divide-gray-200">
        <li class="px-4">
          <RouterLink to="">아이디찾기</RouterLink>
        </li>
        <li class="px-4">
          <RouterLink to="">비밀번호 찾기</RouterLink>
        </li>
        <li class="px-4 text-[#569AFF]">
          <RouterLink to="Signup">회원가입</RouterLink>
        </li>
      </ul>
    </form>
  </div>
</template>

<script setup lang="ts">
import {reactive, ref} from "vue";
import axiosInstance from "../lib/axios.ts";
import {useRouter} from "vue-router";
import {useUserStore} from "../store/authStore.ts";

const router = useRouter()
const store = useUserStore()

interface LoginForm {
  identify: string
  password: string
}

const form = reactive<LoginForm>({
  identify: '',
  password: '',
})

const loading = ref<boolean>(false)
const error = ref<string>('')

const handleLogin = async () => {
  loading.value = true
  error.value = ''

  try {

    const loginData = {
      email: form.identify,
      password: form.password,
    }

    const response = await axiosInstance.post('/api/auth/login', loginData)
    const token = response.data.token
    store.login(token)
    await router.push('/')
  } catch (err : any) {
    error.value = err.message || '로그인에 실패했습니다. 다시 시도해주세요'
  } finally {
    loading.value = false
  }
}

</script>

<style scoped>

</style>