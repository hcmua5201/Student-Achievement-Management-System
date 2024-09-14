

<template>
<!-- Login Page element-plus 有username password role的下拉选择 -->
  <div class="login-container">
    <el-form :model="loginForm" ref="loginForm" label-width="100px">
      <h3>Login</h3>
      <el-form-item label="Username">
        <el-input v-model="loginForm.username" placeholder="Please enter your username"></el-input>
      </el-form-item>
      <el-form-item label="Password">
        <el-input type="password" v-model="loginForm.password" placeholder="Please enter your password" show-password></el-input>
      </el-form-item>
      <el-form-item label="Role">
        <el-select v-model="loginForm.role">
          <el-option label="管理员" value="管理员"></el-option>
          <el-option label="教师" value="教师"></el-option>
          <el-option label="学生" value="学生"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login">Login</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
axios.defaults.baseURL = "http://localhost:8888";

export default {

  data() {
    return {
      loginForm: {
        username: "",
        password: "",
        role: ""
      },


    }
  },
  methods: {
    login() {
      console.log(this.loginForm); // 打印表单数据以确认内容
      console.log("username:", this.loginForm.username);
      console.log("password:", this.loginForm.password);
      console.log("role:", this.loginForm.role);
      axios({
        method: "post",
        url: "/user/login",
        params:{username:this.loginForm.username,password:this.loginForm.password,role:this.loginForm.role}
      })

       .then(response => {
          console.log(response.data);
          if (response.data.code === 200) {
            this.$message.success(response.data.message);
            // 登录成功后将返回到obj保存在浏览器的sessionStorage中
            sessionStorage.setItem("login_info", JSON.stringify(response.data.object));
            // 从sessionStorage中获取登录信息，并判断角色跳转到不同的页面
            let login_info = JSON.parse(sessionStorage.getItem("login_info"));
            if (login_info.role === "管理员") {
              this.$router.push("/admin/admin_home/admin_welcome");
            } else if (login_info.role === "教师") {
              this.$router.push("/teacher/teacher_home/teacher_welcome");
            } else if (login_info.role === "学生") {
              this.$router.push("/student/student_home/student_welcome");
            }

          } else {
            this.$message.error(response.data.message);
          }
        })
       .catch(error => {
          console.log(error);
          this.$message.error("登录失败");
        });
    }
  }
}


</script>

<style scoped>

.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f2f5;
}


h3 {
  text-align: center;
}


.el-form {
  width: 400px;
}
.el-form-item {
  margin-bottom: 20px;
}
.el-input {
  width: 100%;
}
.el-button {
  width: 100%;
}

</style>