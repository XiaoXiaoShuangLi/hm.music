package com.xxscloud.thirdparty.data;

/**
 * @author 李小双 2018.1.29
 */
public class AddressDto {

    /**
     * 省.
     */
    private String province;

    /**
     * 市.
     */
    private String city;

    /**
     * 区.
     */
    private String district;

    /**
     * 街.
     */
    private String street;

    /**
     * 经度纬度.
     */
    private CoordinatesDto coordinates;

    /**
     * 位置信息.
     */
    private String rectangle;

    /**
     * 获取 province .
     *
     * @return province 数据
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置 province .
     *
     * @param provinceValue 设置 province .
     */
    public void setProvince(final String provinceValue) {
        province = provinceValue;
    }

    /**
     * 获取 city .
     *
     * @return city 数据
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置 city .
     *
     * @param cityValue 设置 city .
     */
    public void setCity(final String cityValue) {
        city = cityValue;
    }

    /**
     * 获取 district .
     *
     * @return district 数据
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置 district .
     *
     * @param districtValue 设置 district .
     */
    public void setDistrict(final String districtValue) {
        district = districtValue;
    }

    /**
     * 获取 street .
     *
     * @return street 数据
     */
    public String getStreet() {
        return street;
    }

    /**
     * 设置 street .
     *
     * @param streetValue 设置 street .
     */
    public void setStreet(final String streetValue) {
        street = streetValue;
    }

    /**
     * 获取 coordinates .
     *
     * @return coordinates 数据
     */
    public CoordinatesDto getCoordinates() {
        return coordinates;
    }

    /**
     * 设置 coordinates .
     *
     * @param coordinatesValue 设置 coordinates .
     */
    public void setCoordinates(final CoordinatesDto coordinatesValue) {
        coordinates = coordinatesValue;
    }

    /**
     * 获取 rectangle .
     *
     * @return rectangle 数据
     */
    public String getRectangle() {
        return rectangle;
    }

    /**
     * 设置 rectangle .
     *
     * @param rectangleValue 设置 rectangle .
     */
    public void setRectangle(final String rectangleValue) {
        rectangle = rectangleValue;
    }
}
