

<template>
  <el-dropdown style="float: right; margin: 20px">
            <span class="el-dropdown-link">
              {{ login_info.username }}-{{ login_info.role }} &nbsp;&nbsp;
              <el-icon class="el-icon--right">
                <arrow-down />
              </el-icon>
            </span>
    <template #dropdown>
      <el-dropdown-menu>
        <el-dropdown-item @click.native="toUpdatePassword"
        >修改密码</el-dropdown-item
        >
        <el-dropdown-item @click.native="logout">退出系统</el-dropdown-item>
      </el-dropdown-menu>
    </template>
  </el-dropdown>
</template>
<script >
import {ArrowDown} from "@element-plus/icons-vue";

export default {
  components: {ArrowDown},
  data() {
    return {
      login_info: null
    }
  },
  created() {
    this.login_info = JSON.parse(sessionStorage.getItem("login_info"));
    if (!this.login_info) {
      this.$router.push("/login");
    }
  },
  methods: {
    toUpdatePassword() {

    },
    logout() {
      sessionStorage.clear();
      this.$router.push("/login");
    }
  }
}
</script>
<style >
.el-dropdown-link {
  cursor: pointer;
  color: black;
  border: none !important;
}
.el-icon-arrow-down {
  font-size: 12px;
  border: none !important;
}
.el-dropdown-link:focus {
  outline: none !important;
}
</style>