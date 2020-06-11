package com.epam.sort;

import com.epam.entity.NewsNote;

import java.util.Comparator;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class NewsNoteSortTemplates  implements Comparator<NewsNote>{
    @Override
    public int compare(NewsNote o1, NewsNote o2) {
        return 0;
    }

    public static NewsNoteSortTemplates byDate(){
    return new NewsNoteSortTemplates(){
        @Override
        public int compare(NewsNote o1, NewsNote o2) {
            if (o1.getDate().after(o2.getDate())){
                return -1;
            } else {
                if (o1.getDate().before(o2.getDate())){
                    return 1;
                } else{
                    return 0;
                }
            }
        }
    };
}
}
