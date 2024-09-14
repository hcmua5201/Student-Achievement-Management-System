import {createRouter, createWebHistory} from 'vue-router'




const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            redirect: "/login",
        },
        {
            path: '/login',
            component: () => import('../views/login.vue')
        },

        // 管理员端路由
        {
            path: "/admin/admin_home",
            name: "/admin/admin_home",
            component: () => import("../views/admin/admin_Home.vue"),
            children: [
                {
                    path: "admin_welcome",
                    name: "admin_welcome",
                    component: () => import("../views/admin/admin_welcome.vue")
                },
                {
                    path: "admin_main_StudentManage",
                    name: "admin_main_StudentManage",
                    component: () => import("../views/admin/admin_main_StudentManage.vue")
                },
            ]

        },
        //学生端路由
        {
            path: "/student/student_home",
            name: "/student/student_home",
            component: () => import("../views/student/student_Home.vue"),
            children: [
                {
                    path: "student_welcome",
                    name: "student_welcome",
                    component: () => import("../views/student/student_welcome.vue")
                }
            ]
        },
        //教师端路由
        {
            path: "/teacher/teacher_home",
            name: "/teacher/teacher_home",
            component: () => import("../views/teacher/teacher_Home.vue"),
            children: [
                {
                    path: "teacher_welcome",
                    name: "teacher_welcome",
                    component: () => import("../views/teacher/teacher_welcome.vue")
                }
            ]
        }



    ]
})
// 路由守卫
router.beforeEach((to, from, next) => {
    // 登录验证
    if (to.path === '/') {
        next()
    } else {
        const login_info = localStorage.getItem('login_info')
        if (login_info) {
            next()
        } else {
            next('/')
        }
    }
})


export default router;
