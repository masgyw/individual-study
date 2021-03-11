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
        columns: columns,
        datas: null,
        pageInfo: {}
      }
    },
    methods: {
      query({ page, limit }) {
        this.BASE_APIS.findByPage(apiTypes.FILE_INFO, { page, limit })
          .then(resp => {
            this.datas = resp.data.records;
            this.pageInfo = resp.data.pageInfo;
          });
      },
      add(params) {
        this.BASE_APIS.offer(apiTypes.FILE_INFO, params)
          .then(resp => {
            this.query(this.pageInfo);
          })
      },
      deleteRow(params) {
        this.BASE_APIS.remove(apiTypes.FILE_INFO, params)
          .then(resp => {
            this.query(this.pageInfo);
          })
      }
    },
    created() {
      this.query({ page: 1, limit: 10 });
      console.log(columns)
    }
  }
</script>
<style lang="scss" scoped>
</style>