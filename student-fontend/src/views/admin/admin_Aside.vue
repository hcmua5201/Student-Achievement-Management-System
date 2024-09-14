

<template>
  <el-col :span="24">
    <h5 class="mb-2">学生成绩管理系统</h5>
    <el-menu
        style="height: 90vh"
        default-active="/admin/admin_home/admin_welcome"
        class="el-menu-style"
        router
    >
      <el-menu-item index="/admin/admin_home/admin_welcome"><el-icon><house /></el-icon>首页</el-menu-item>
      <el-menu-item index="/admin/admin_home/admin_main_StudentManage"><el-icon><Setting /></el-icon>学生管理</el-menu-item>
      <el-menu-item index="/admin/teacher"><el-icon><user /></el-icon>教师管理</el-menu-item>
      <el-menu-item index="/admin/class"><el-icon><Document /></el-icon>班级管理</el-menu-item>



    </el-menu>
  </el-col>
</template>
<script >

import {Document, Setting, User, House} from "@element-plus/icons-vue";
import {defineComponent} from "vue";

export default defineComponent({
  components: {House, Setting, User, Document}
})

</script>

<style scoped lang="scss">
.el-menu {
  height: 100%;
}

.el-menu-style:not(.el-menu--collapse) {
  width: auto;
  min-height: 400px;
}
</style>