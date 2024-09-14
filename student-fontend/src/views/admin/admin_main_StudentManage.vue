<template>
  <el-row>
    <el-col :span="12">
      <el-input v-model="searchStudentNumber" placeholder="请输入学号" style="width: 200px; margin-bottom: 10px;" />
      <el-button type="primary" @click="searchStudentByNumber">查询</el-button>
    </el-col>
    <el-col :span="12">
      <el-select v-model="selectClass" placeholder="请选择班级" style="width: 200px; margin-bottom: 10px;">
        <el-option v-for="item in classList" :key="item.id" :label="item.name" :value="item.name"></el-option>
      </el-select>
      <el-button type="primary" @click="searchStudentByClass">查询</el-button>
    </el-col>
  </el-row>
  <el-table :data="studentList" style="width: 100%">
    <el-table-column type="index" label="序号" width="auto"></el-table-column>
    <el-table-column prop="number" label="学号" width="auto"></el-table-column>
    <el-table-column prop="username" label="姓名" width="auto"></el-table-column>
    <el-table-column prop="password" label="密码" type="password" width="auto"></el-table-column>
    <el-table-column prop="gender" label="性别" width="auto"></el-table-column>
    <el-table-column prop="name" label="班级" width="auto"></el-table-column>
    <el-table-column prop="phone" label="手机号" width="auto"></el-table-column>
    <el-table-column label="操作" width="120">
      <template v-slot="scope">
        <el-button type="text" @click="editStudent(scope.row)">编辑</el-button>
        <el-button type="text" @click="deleteStudent(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import axios from "axios";
axios.defaults.baseURL = "http://localhost:8888";

export default {
  name: "AdminMainStudentManage",
  data() {
    return {
      dialogVisible: false,
      studentForm: {
        number: "",
        username: "",
        password: "",
        gender: "",
        name: "",
        phone: "",
      },
      studentList: [],
      total: 0,
      searchStudentNumber: "",
      selectClass: "",
      classList: [],
    };
  },
  created() {
    this.getStudentList();
    this.getClassList();
  },
  methods: {
    async getStudentList() {
      try {
        const res = await axios.get("/admin/GetAllUserInfo");
        this.studentList = res.data.object || [];
        this.total = res.data.total || 0; // 如果有总数信息，也进行赋值
      } catch (error) {
        console.error("获取学生列表失败:", error);
        // 可以在这里添加用户友好的错误提示
      }
    },

    async getClassList() {
      try {
        const res = await axios.get("/admin/GetClassList");
        this.classList = res.data.object || [];
      } catch (error) {
        console.error("获取班级列表失败:", error);
        // 添加错误处理
      }
    },

    async handleEdit() {
      try {
        await axios.post("/admin/EditUserInfo", this.studentForm);
        this.dialogVisible = false;
        await this.getStudentList();
      } catch (error) {
        console.error("编辑学生信息失败:", error);
        // 添加错误处理
      }
    },

    handleClose() {
      this.dialogVisible = false;
    },

    searchStudentByNumber() {
      if (this.searchStudentNumber === "") {
        this.$message.error("请输入学号");
        return;
      }
      axios.get("/admin/searchByNumber/" + this.searchStudentNumber)
       .then((res) => {
         console.log(res.data)
          this.studentList = res.data.object
          // this.total = res.data.total || 0;
        })

        // this.total = res.data.total || 0;
    },

    async searchStudentByClass() {
      console.log(this.selectClass)
      if (this.selectClass === "") {
        this.$message.error("请选择班级");
        return;
      }
      //根据班级名称查询学生
      try {
        const res = await axios.get("/admin/searchByClassName/" + this.selectClass);
        console.log(res.data)
        this.studentList = res.data.object || [];
        this.total = res.data.total || 0; // 如果有总数信息，也进行赋值
      } catch (error) {
        console.error("根据班级查询学生失败:", error);
        // 可以在这里添加用户友好的错误提示
      }

    },

    editStudent(student) {
      this.dialogVisible = true;
      this.studentForm = Object.assign({}, student); // 确保是一个新的对象
    },

    deleteStudent(student) {
      console.log(student);
      // 这里可以添加删除学生的逻辑
      // 用 this.$confirm 弹出确认框
      this.$confirm("确认删除该学生吗？").then(() => {
        // 确认删除
        console.log("确认删除");
      }).catch(() => {
        // 取消删除
        console.log("取消删除");
      });
    },

    handleCurrentChange(currentPage) {
      console.log(currentPage);
      // 可以根据当前页面请求相应数据
    },
  },
};
</script>

<style scoped>

</style>
