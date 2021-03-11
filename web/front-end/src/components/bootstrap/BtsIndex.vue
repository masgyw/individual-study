<template>
    <div>
        <!-- <h2>BootStrap学习</h2> -->
        <!-- <hr> -->
        <!-- <bts-button></bts-button> -->
        <!-- <bts-img></bts-img> -->
        <!-- <bts-text></bts-text> -->
        <!-- <bts-list></bts-list> -->
        <!-- <bts-table></bts-table> -->
        <!-- <bts-grid></bts-grid> -->
        <!-- <bts-griddemo></bts-griddemo> -->
        <!-- <bts-griddemo2></bts-griddemo2> -->
        <!-- <bts-form></bts-form> -->
        <!-- <bts-select></bts-select> -->
        <!-- <bts-nav></bts-nav> -->
        <!-- <bts-icon></bts-icon> -->
        <!-- <bts-comps></bts-comps> -->
		<bts-plugin></bts-plugin>
    </div>
</template>

<script>

    import BtsButton from '@/components/bootstrap/BtsButton';
    import BtsImg from '@/components/bootstrap/BtsImg';
    import BtsText from '@/components/bootstrap/BtsText';
    import BtsList from '@/components/bootstrap/BtsList';
    import BtsTable from '@/components/bootstrap/BtsTable';
    import BtsGrid from '@/components/bootstrap/BtsGrid';
    import BtsGridDemo from '@/components/bootstrap/BtsGridDemo';
    import BtsGridDemo2 from '@/components/bootstrap/BtsGridDemo2';
    import BtsForm from '@/components/bootstrap/BtsForm';
    import BtsSelect from '@/components/bootstrap/BtsSelect';
    import BtsNav from '@/components/bootstrap/BtsNav';
    import BtsIcon from '@/components/bootstrap/BtsIcon';
	import BtsComps from '@/components/bootstrap/BtsComponents';
	import BtsJsplugin from '@/components/bootstrap/BtsJsPlugin';

    export default {

        components: {
            "bts-grid": BtsGrid,
            "bts-griddemo": BtsGridDemo,
            "bts-griddemo2": BtsGridDemo2,
            "bts-button": BtsButton,
            "bts-img": BtsImg,
            "bts-text": BtsText,
            "bts-list": BtsList,
            "bts-table": BtsTable,
            "bts-form": BtsForm,
            "bts-select": BtsSelect,
            "bts-nav": BtsNav,
            "bts-icon": BtsIcon,
			"bts-comps": BtsComps,
			"bts-plugin": BtsJsplugin
        }

    }
</script>

<style scoped>
   
</style>