import { createApp } from 'vue'

import App from './App.vue'
import elementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router/router.js'
import '@element-plus/icons-vue'
const app = createApp(App)
app.use(elementPlus)
app.use(router)
app.mount('#app')
