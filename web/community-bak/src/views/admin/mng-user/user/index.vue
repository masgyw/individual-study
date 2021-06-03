<template>
  <div class="app-container">
    <!-- v-if 在获取到columns 信息后才传递给子组件 -->
    <table-view v-if="columns.length > 0" :tableDatas="datas" :columns="columns" :pageInfo="pageInfo"
      @pageChange="query" @deleteRow="deleteRow" @addData="add">
    </table-view>
  </div>
</template>

<script>
  import apiTypes from '@/api/api-types'
  import { columns } from './meta.js'
  import TableView from '@/components/TableView'

  export default {
    name: "UserMng",
    components: {
      TableView
    },
    data() {
      return {
        columns: [],
        datas: null,
        pageInfo: {}
      }
    },
    methods: {
      getAllRoles() {
        this.BASE_APIS.findAll(apiTypes.ROLE)
          .then(resp => {
            let roleList = resp.data;
            let roleCol = columns.find(element => element.prop == "roleId");
            let selectOptions = [];
            for (let i = 0, len = roleList.length; i < len; i++) {
              selectOptions.push({
                "label": roleList[i].roleName,
                "value": roleList[i].roleId
              })
            }
            roleCol.selectOptions = selectOptions;
            this.columns = columns;
            console.log("columns:", this.columns);
          });
      },
      query({ page, limit }) {
        this.BASE_APIS.findByPage(apiTypes.USER, { page, limit })
          .then(resp => {
            this.datas = resp.data.records;
            this.pageInfo = resp.data.pageInfo;
          });
      },
      add(params) {
        this.BASE_APIS.offer(apiTypes.USER, params)
          .then(resp => {
            this.query(this.pageInfo);
          })
      },
      deleteRow(params) {
        this.BASE_APIS.remove(apiTypes.USER, params)
          .then(resp => {
            this.query(this.pageInfo);
          })
      }
    },
    created() {
      this.query({ page: 1, limit: 10 });
      this.getAllRoles();
    }
  }
</script>
<style lang="scss" scoped>
</style>