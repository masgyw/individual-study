<template>
  <div class="app-container">
    <table-view :tableDatas="datas" :columns="columns" :pageInfo="pageInfo"
      @addData="add" 
      @deleteRow="deleteRow"
      @pageChange="query"
      >
    </table-view>
  </div>
</template>

<script>
  import apiTypes from '@/api/api-types'
  import {columns} from './meta.js'
  import TableView from '@/components/TableView'

  export default {
    name: "ProductInfoMng",
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
      query({page, limit}) {
        this.BASE_APIS.findByPage(apiTypes.PRODUCT_INFO, { page, limit })
          .then(resp => {
            this.datas = resp.data.records;
            this.pageInfo = resp.data.pageInfo;
          });
      },
      add(params) {
        this.BASE_APIS.offer(apiTypes.PRODUCT_INFO, params)
          .then(resp => {
            this.query(this.pageInfo);
          })
      },
      deleteRow(data) {
        this.BASE_APIS.remove(apiTypes.PRODUCT_INFO,
          { "productCore": data.productCore })
          .then(resp => {
            this.query(this.pageInfo);
          })
      }
    },
    created() {
      this.query({page:1, limit:10});
    }
  }
</script>
<style lang="scss" scoped>
</style>