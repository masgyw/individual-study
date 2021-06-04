<template>
  <el-container>
    <el-aside width="200px">
      <el-input placeholder="输入关键字进行过滤" v-model="filterText">
      </el-input>
      <el-tree ref="tree" :data="mdFileList" :props="defaultProps" accordion @node-click="handleNodeClick"
        :filter-node-method="filterNode" highlight-current></el-tree>
    </el-aside>
    <el-main>
      <BaseMarkdown :md="showMd"></BaseMarkdown>
    </el-main>
  </el-container>
</template>
<script>
  import axios from 'axios';
  import { queryAllMd } from '@/api/api-file-service.js';
  import BaseMarkdown from '@/components/BaseMarkdown'

  export default {
    components: {
      BaseMarkdown
    },
    data() {
      return {
        filterText: '',
        mdFileList: [],
        defaultProps: {
          children: 'children',
          label: 'label'
        },
        showMd: "",
      }
    },
    watch: {
      filterText(val) {
        this.$refs.tree.filter(val);
      }
    },
    methods: {
      handleNodeClick(data, curNode) {
        // not file node , return
        if (data.children.length > 0) {
          return;
        }
        // file node
        let dir = curNode.parent.data.fileName;
        if (dir == undefined) {
          dir = "";
        }
        let api = dir + "/" + data.fileName;
        axios.get(this.FILE_SERVICE + 'md/' + api, {
          headers: {
            'Cache-Control': 'no-cache'
          }
        }).then(resp => {
          this.showMd = resp.data;
        })
      },
      filterNode(value, data) {
        if (!value) return true;
        return data.label.indexOf(value) !== -1;
      }
    },

    created() {
      queryAllMd().then(resp => {
        this.mdFileList = resp.data;
      }).catch(err => {

      })
    }
  };
</script>
<style scoped>
</style>