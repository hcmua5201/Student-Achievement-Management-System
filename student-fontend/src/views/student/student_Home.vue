

<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px">
        <Aside></Aside>
      </el-aside>
      <el-container>
        <el-header>
          <Header></Header>
        </el-header>
        <el-main class="main-content">
          <router-view ></router-view>
        </el-main>
        <el-footer>Copyright © 2024 公众号：何超技术团队</el-footer>
      </el-container>
    </el-container>
  </div>
</template>
<script >
import Aside from "./student_Aside.vue";
import Header from "./student_Header.vue";

export default {
  components:{
    Aside,Header
  }
}

</script>
<style >
.main-content{
  background-color: #4a72ad;
}
</style>