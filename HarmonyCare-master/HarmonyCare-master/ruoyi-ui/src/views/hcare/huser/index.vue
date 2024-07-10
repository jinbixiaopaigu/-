<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户名" prop="hcUsername">
        <el-input
          v-model="queryParams.hcUsername"
          placeholder="请输入用户名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="姓名" prop="hcName">
        <el-input
          v-model="queryParams.hcName"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年龄" prop="hcAge">
        <el-input
          v-model="queryParams.hcAge"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="hcGender">
        <el-select v-model="queryParams.hcGender" placeholder="请选择性别">
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="手机号" prop="hcPhone">
        <el-input
          v-model="queryParams.hcPhone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="角色" prop="hcRole">
        <el-select v-model="queryParams.hcRole" placeholder="请选择角色">
          <el-option label="老年" value="老年"></el-option>
          <el-option label="子女" value="子女"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="绑定ID" prop="hcBindingid">
        <el-input
          v-model="queryParams.hcBindingid"
          placeholder="请输入绑定ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['hcare:huser:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['hcare:huser:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['hcare:huser:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hcare:huser:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="huserList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户ID" align="center" prop="hcUserid" />
      <el-table-column label="用户名" align="center" prop="hcUsername" />
      <el-table-column label="密码" align="center" prop="hcPassword" />
      <el-table-column label="姓名" align="center" prop="hcName" />
      <el-table-column label="年龄" align="center" prop="hcAge" />
      <el-table-column label="性别" align="center" prop="hcGender" />
      <el-table-column label="手机号" align="center" prop="hcPhone" />
      <el-table-column label="角色" align="center" prop="hcRole" />
      <el-table-column label="绑定ID" align="center" prop="hcBindingid" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hcare:huser:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hcare:huser:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改Hcare用户对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户名" prop="hcUsername">
          <el-input v-model="form.hcUsername" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="密码" prop="hcPassword">
          <el-input v-model="form.hcPassword" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item label="姓名" prop="hcName">
          <el-input v-model="form.hcName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="年龄" prop="hcAge">
          <el-input v-model="form.hcAge" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="性别" prop="hcGender">
          <el-select v-model="form.hcGender" placeholder="请选择性别">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="手机号" prop="hcPhone">
          <el-input v-model="form.hcPhone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="角色" prop="hcRole">
          <el-select v-model="form.hcRole" placeholder="请选择角色">
            <el-option label="老年" value="老年"></el-option>
            <el-option label="子女" value="子女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="绑定ID" prop="hcBindingid">
          <el-input v-model="form.hcBindingid" placeholder="请输入绑定ID" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listHuser, getHuser, delHuser, addHuser, updateHuser } from "@/api/hcare/huser";

export default {
  name: "Huser",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // Hcare用户表格数据
      huserList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        hcUsername: null,
        hcPassword: null,
        hcName: null,
        hcAge: null,
        hcGender: null,
        hcPhone: null,
        hcRole: null,
        hcBindingid: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        hcUsername: [
          { required: true, message: "用户名不能为空", trigger: "blur" }
        ],
        hcPassword: [
          { required: true, message: "密码不能为空", trigger: "blur" }
        ],
        hcName: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询Hcare用户列表 */
    getList() {
      this.loading = true;
      listHuser(this.queryParams).then(response => {
        this.huserList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        hcUserid: null,
        hcUsername: null,
        hcPassword: null,
        hcName: null,
        hcAge: null,
        hcGender: null,
        hcPhone: null,
        hcRole: null,
        hcBindingid: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.hcUserid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加Hcare用户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const hcUserid = row.hcUserid || this.ids
      getHuser(hcUserid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改Hcare用户";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.hcUserid != null) {
            updateHuser(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHuser(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const hcUserids = row.hcUserid || this.ids;
      this.$modal.confirm('是否确认删除Hcare用户编号为"' + hcUserids + '"的数据项？').then(function() {
        return delHuser(hcUserids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('hcare/huser/export', {
        ...this.queryParams
      }, `huser_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
