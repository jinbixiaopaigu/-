<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户ID" prop="hcUserid">
        <el-input
          v-model="queryParams.hcUserid"
          placeholder="请输入用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="摔倒时间" prop="hcFalltime">
        <el-date-picker
          v-model="queryParams.hcFalltime"
          type="date"
          placeholder="选择日期"
          value-format="yyyy-MM-dd"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="检测结果" prop="hcDetectionresult">
        <el-select v-model="queryParams.hcDetectionresult" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
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
          v-hasPermi="['hcare:falldetection:add']"
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
          v-hasPermi="['hcare:falldetection:edit']"
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
          v-hasPermi="['hcare:falldetection:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hcare:falldetection:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="falldetectionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户ID" align="center" prop="hcUserid" />
      <el-table-column label="摔倒时间" align="center" prop="hcFalltime" />
      <el-table-column label="检测结果" align="center" prop="hcDetectionresult" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hcare:falldetection:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hcare:falldetection:remove']"
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

    <!-- 添加或修改摔倒检测对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户ID" prop="hcUserid">
          <el-input v-model="form.hcUserid" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="摔倒时间" prop="hcFalltime">
          <el-date-picker
            v-model="form.hcFalltime"
            type="datetime"
            placeholder="选择日期时间"
            value-format="yyyy-MM-dd HH:mm:ss"
          />
        </el-form-item>
        <el-form-item label="检测结果" prop="hcDetectionresult">
          <el-select v-model="form.hcDetectionresult" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
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
import { listFalldetection, getFalldetection, delFalldetection, addFalldetection, updateFalldetection } from "@/api/hcare/falldetection";

export default {
  name: "Falldetection",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      options: [
        { value: '轻度', label: '轻度' },
        { value: '中度', label: '中度' },
        { value: '重度', label: '重度' }
      ],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 摔倒检测表格数据
      falldetectionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        hcUserid: null,
        hcFalltime: null,
        hcDetectionresult: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        hcUserid: [
          { required: true, message: "用户ID不能为空", trigger: "blur" }
        ],
        hcFalltime: [
          { required: true, message: "摔倒时间不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询摔倒检测列表 */
    getList() {
      this.loading = true;
      listFalldetection(this.queryParams).then(response => {
        this.falldetectionList = response.rows;
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
        hcDataid: null,
        hcUserid: null,
        hcFalltime: null,
        hcDetectionresult: null
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
      this.ids = selection.map(item => item.hcDataid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加摔倒检测";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const hcDataid = row.hcDataid || this.ids
      getFalldetection(hcDataid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改摔倒检测";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.hcDataid != null) {
            updateFalldetection(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFalldetection(this.form).then(response => {
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
      const hcDataids = row.hcDataid || this.ids;
      this.$modal.confirm('是否确认删除摔倒检测编号为"' + hcDataids + '"的数据项？').then(function() {
        return delFalldetection(hcDataids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('hcare/falldetection/export', {
        ...this.queryParams
      }, `falldetection_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
