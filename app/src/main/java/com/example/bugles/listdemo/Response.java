package com.example.bugles.listdemo;

import java.util.List;

/**
 * Created by bugles on 2018-02-12.
 */

public class Response {


    /**
     * status : 1
     * error :
     * data : [{"id":193847,"title":"保费最优惠 服务最完美! 诚聘精英保险经纪","summary":"Ken Chen Managing Partner, RIBO, Canadian Accredited Insurance Broker All-Risks Insurance Brokers，安省最大保险代理商之一，代理数十家正规保险公司。 Ke ...","url":"http://api.51.ca/wen8app/detailpage/service/#/item/193847","is_sticky":1,"is_highlight":0,"is_fav":0,"time":"2016-04-21 16:00","contact":{"name":"平安保险 服务团队","phone1":"416-817-5555","phone1_ext":"","phone2":"647-995-6799","phone2_ext":""},"count_image_src":"","service":{"serviceid":"39","tag":"汽车保险"},"city":{"cityid":"1","tag":"大多地区"},"languages":{"language":"3","tag":"英 / 国"}},{"id":143666,"title":"销售性价比最高保险，最高佣金招聘保险经纪","summary":"最具诚信的专业持牌经纪团队，代理一般经纪行没有的，团体车，房保险。性价比在市面几乎无可匹敌。另有20余家大型汽车, 房屋，商业，人寿，旅游保险公司可供选择 ...","url":"http://api.51.ca/wen8app/detailpage/service/#/item/143666","is_sticky":1,"is_highlight":0,"is_fav":0,"time":"2011-11-04 14:26","contact":{"name":"Denis_Li","phone1":"647-857-8553","phone1_ext":""},"count_image_src":"","service":{"serviceid":"39","tag":"汽车保险"},"city":{"cityid":"1","tag":"大多地区"},"languages":{"language":"3","tag":"英 / 国"}}]
     */

    private int status;
    private String error;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 193847
         * title : 保费最优惠 服务最完美! 诚聘精英保险经纪
         * summary : Ken Chen Managing Partner, RIBO, Canadian Accredited Insurance Broker All-Risks Insurance Brokers，安省最大保险代理商之一，代理数十家正规保险公司。 Ke ...
         * url : http://api.51.ca/wen8app/detailpage/service/#/item/193847
         * is_sticky : 1
         * is_highlight : 0
         * is_fav : 0
         * time : 2016-04-21 16:00
         * contact : {"name":"平安保险 服务团队","phone1":"416-817-5555","phone1_ext":"","phone2":"647-995-6799","phone2_ext":""}
         * count_image_src :
         * service : {"serviceid":"39","tag":"汽车保险"}
         * city : {"cityid":"1","tag":"大多地区"}
         * languages : {"language":"3","tag":"英 / 国"}
         */

        private int id;
        private String title;
        private String summary;
        private String url;
        private int is_sticky;
        private int is_highlight;
        private int is_fav;
        private String time;
        private ContactBean contact;
        private String count_image_src;
        private ServiceBean service;
        private CityBean city;
        private LanguagesBean languages;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getIs_sticky() {
            return is_sticky;
        }

        public void setIs_sticky(int is_sticky) {
            this.is_sticky = is_sticky;
        }

        public int getIs_highlight() {
            return is_highlight;
        }

        public void setIs_highlight(int is_highlight) {
            this.is_highlight = is_highlight;
        }

        public int getIs_fav() {
            return is_fav;
        }

        public void setIs_fav(int is_fav) {
            this.is_fav = is_fav;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public ContactBean getContact() {
            return contact;
        }

        public void setContact(ContactBean contact) {
            this.contact = contact;
        }

        public String getCount_image_src() {
            return count_image_src;
        }

        public void setCount_image_src(String count_image_src) {
            this.count_image_src = count_image_src;
        }

        public ServiceBean getService() {
            return service;
        }

        public void setService(ServiceBean service) {
            this.service = service;
        }

        public CityBean getCity() {
            return city;
        }

        public void setCity(CityBean city) {
            this.city = city;
        }

        public LanguagesBean getLanguages() {
            return languages;
        }

        public void setLanguages(LanguagesBean languages) {
            this.languages = languages;
        }

        public static class ContactBean {
            /**
             * name : 平安保险 服务团队
             * phone1 : 416-817-5555
             * phone1_ext :
             * phone2 : 647-995-6799
             * phone2_ext :
             */

            private String name;
            private String phone1;
            private String phone1_ext;
            private String phone2;
            private String phone2_ext;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhone1() {
                return phone1;
            }

            public void setPhone1(String phone1) {
                this.phone1 = phone1;
            }

            public String getPhone1_ext() {
                return phone1_ext;
            }

            public void setPhone1_ext(String phone1_ext) {
                this.phone1_ext = phone1_ext;
            }

            public String getPhone2() {
                return phone2;
            }

            public void setPhone2(String phone2) {
                this.phone2 = phone2;
            }

            public String getPhone2_ext() {
                return phone2_ext;
            }

            public void setPhone2_ext(String phone2_ext) {
                this.phone2_ext = phone2_ext;
            }
        }

        public static class ServiceBean {
            /**
             * serviceid : 39
             * tag : 汽车保险
             */

            private String serviceid;
            private String tag;

            public String getServiceid() {
                return serviceid;
            }

            public void setServiceid(String serviceid) {
                this.serviceid = serviceid;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }
        }

        public static class CityBean {
            /**
             * cityid : 1
             * tag : 大多地区
             */

            private String cityid;
            private String tag;

            public String getCityid() {
                return cityid;
            }

            public void setCityid(String cityid) {
                this.cityid = cityid;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }
        }

        public static class LanguagesBean {
            /**
             * language : 3
             * tag : 英 / 国
             */

            private String language;
            private String tag;

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }
        }
    }
}
