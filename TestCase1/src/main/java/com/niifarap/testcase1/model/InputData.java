package com.niifarap.testcase1.model;

public class InputData {

    /**
    /**
     * Входной текст, содержайщий дату в формате dd.mm.yyyy
     */
    private String text;

    /**
     * Количество дней для увеличения
     */
    private Integer increaseDateCount;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getIncreaseDateCount() {
        return increaseDateCount;
    }

    public void setIncreaseDateCount(Integer increaseDateCount) {
        this.increaseDateCount = increaseDateCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputData inputData = (InputData) o;

        if (text != null ? !text.equals(inputData.text) : inputData.text != null) return false;
        return increaseDateCount != null ? increaseDateCount.equals(inputData.increaseDateCount) : inputData.increaseDateCount == null;

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (increaseDateCount != null ? increaseDateCount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "text='" + text + '\'' +
                ", increaseDateCount=" + increaseDateCount +
                '}';
    }
}
