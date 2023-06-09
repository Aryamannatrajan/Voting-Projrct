/*
 * Copyright (C) 2020 abhimanyuyadav
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package adminvoter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abhimanyuyadav
 */
public class LoadThread implements Runnable {

    @Override
    public void run() {
        try {
            new AdMain3().setVisible(true);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoadThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoadThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoadThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
