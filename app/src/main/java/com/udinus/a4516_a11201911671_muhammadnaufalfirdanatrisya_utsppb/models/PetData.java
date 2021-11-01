package com.udinus.a4516_a11201911671_muhammadnaufalfirdanatrisya_utsppb.models;

import java.util.ArrayList;

public class PetData {
    public static String[][] data = new String[][]{

            {"Kucing Persia", "Pemilik sebelumnya:Bambang", "https://cdns.klimg.com/merdeka.com/i/w/news/2020/04/07/1164448/content_images/670x335/20200407165355-1-jenis-kucing-persia-004-andre-kurniawan.png",
                    "Kucing Persia merupakan salah satu jenis kucing yang paling banyak disukai di dunia. Hal itu disebabkan karena penampakan dari kucing satu ini yang sangat cantik dan menggemaskan. Akan tetapi pernahkah anda mendengar kata kucing persia medium? Ya, nama kucing ini memang sering kita dengar di Indonesia, Malaysia, Singapura, dan lain sebagainya.",
                    "Semarang, Jawa Tengah"},
            {"Anjing Shiba Inu", "Pemilik sebelumnya: Elon Musk", "https://asset.kompas.com/crops/z5s35e04XSesog8-mpgCtUnGtQE=/3x1:725x482/750x500/data/photo/2021/05/12/609ba67f4bbc7.png",
                    "Shiba Inu (柴犬, Anjing Shiba) merupakan salah satu anjing asli asal Jepang yang telah ada sejak pada zaman kuno. Anjing ini menjadi ras paling populer yang ada di negara Jepang. Tipe anjing ini ukurannya sedang dengan tinggi badan pada anjing jantan sekitar 38 – 41 cm, sementara untuk tinggi badan anjing betina sekitar 35 – 38 cm.",
                    "Bandung, Jawa Barat"},
            {"Kucing Himalaya", "Pemilik  sebelumnya: Windah ", "https://www.bing.com/th?id=OIP.xBLPx1BZCdzvlcIGjiM_7QHaFS&w=138&h=100&c=8&rs=1&qlt=90&o=6&dpr=1.25&pid=3.1&rm=2",
                    "Kucing himalaya atau kucing persia himalaya (dahulu bernama kucing persia warna poin) adalah salah satu ras kucing domestik yang merupakan hasil persilangan antara kucing persia dengan kucing siam.",
                    "Solo, Jawa Tengah"},
            {"Burung Beo Putih", "Pemilik sebelumnya : Gunawan","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpWHu_z0v6tbvgGumJk59aPhjTYV4eDsnHrpPvKFnCRwCUKOvoCvgPCk82PXtZIvmxloM&usqp=CAU",
                    "Jenis burung beo memiliki sayap putih besar yang jelas saat terbang. Paruh dan kakinya yang kuat berwarna kuning cerah atau oranye,",
                    "Surabaya, Jawa Timur"},
            {"Aning Siba Inu Hitam", "Pemilik sebelmumnya: Parto", "https://assets.petpintar.com/files/userfiles/2/1597982311-jenis-anjing-ras-terbaik-9.jpg",
                    "Shiba Inu (柴犬, Anjing Shiba) merupakan salah satu anjing asli asal Jepang yang telah ada sejak pada zaman kuno. Anjing ini menjadi ras paling populer yang ada di negara Jepang. Tipe anjing ini ukurannya sedang dengan tinggi badan pada anjing jantan sekitar 38 – 41 cm, sementara untuk tinggi badan anjing betina sekitar 35 – 38 cm.",
                    "Kabupaten Bangli, Bali"},
            {"Kelini Anggora", "Pemilik sebelumnya: Jones ", "https://zonaternak.com/wp-content/uploads/2021/01/Kelinci-Anggora-Inggris.jpg",
                    "Kelinci Angora adalah salah satu jenis tertua dari kelinci domestik, dibiakkan untuk serat panjang mantelnya, yang dikenal sebagai wol Angora, yang dikumpulkan dengan mencukur, menyisir, atau mencabut",
                    "Malang, Jawa Timur"},

    };

    public static ArrayList<Pet> getListData(){
        Pet pet = null;
        ArrayList<Pet> list = new ArrayList<>();
        for (String[] aData : data) {
            pet = new Pet();
            pet.setName(aData[0]);
            pet.setRemarks(aData[1]);
            pet.setPhoto(aData[2]);
            pet.setDeskripsi(aData[3]);
            pet.setLokasi(aData[4]);

            list.add(pet);
        }

        return list;
    }
}