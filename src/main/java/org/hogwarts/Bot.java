package org.hogwarts;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

public class Bot extends TelegramLongPollingBot {
    // База данных самолетов (в реальном проекте используйте БД)
    private final Map<String, Aircraft> aircraftDB = new HashMap<>(){
        {
            put("240", new Aircraft("Есть", "Два медиа-сервера", "Нету",  "Есть"));
                    put("230", new Aircraft("Нету", "Два медиа-сервера", "Нету", "Есть"));
                    put("244", new Aircraft("Нет информации", "Два медиа-сервера", "Нету", "Есть"));
                    put("228", new Aircraft("Нет информации", "Два медиа-сервера", "Нету", "Есть"));
                    put("309", new Aircraft("Нет информации", "Два медиа-сервера", "Нету", "Есть"));
                    put("236", new Aircraft("Есть", "Два медиа-сервера", "Есть", "Нету"));
                    put("299", new Aircraft("Нет информации", "Два медиа-сервера", "Есть", "Есть"));
                    put("227", new Aircraft("Нет информации", "Два медиа-сервера", "Нету", "Есть"));
                    put("241", new Aircraft("Есть", "Два медиа-сервера", "Нету", "Есть"));
                    put("226", new Aircraft("Нет информации", "Два медиа-сервера", "Нету", "Есть"));
                    put("229", new Aircraft("Есть", "Два медиа-сервера", "Нету", "Есть"));
                    put("232", new Aircraft("Нет информации", "Два медиа-сервера", "Нету", "Есть"));
                    put("239", new Aircraft("Есть", "Два медиа-сервера", "Нету", "Есть"));
                    put("238", new Aircraft("Есть", "Два медиа-сервера", "Нету", "Есть"));
                    put("247", new Aircraft("Нету", "Один медиа-сервер", "Нету", "Есть"));
                    put("308", new Aircraft("Есть", "Один медиа-сервер", "Нету", "Есть"));
                    put("296", new Aircraft("Есть", "Один медиа-сервер", "Есть", "Есть"));
                    put("297", new Aircraft("Нету", "Один медиа-сервер", "Есть", "Есть"));
                    put("301", new Aircraft("Есть", "Один медиа-сервер", "Есть", "Есть"));
                    put("304", new Aircraft("Есть", "Один медиа-сервер", "Нету", "Есть"));
                    put("242", new Aircraft("Нет информации", "Один медиа-сервер", "Есть", "Нету"));
                    put("234", new Aircraft("Есть", "Один медиа-сервер", "Есть", "Нету"));
                    put("295", new Aircraft("Есть", "Один медиа-сервер", "Нету", "Есть"));
                    put("231", new Aircraft("Есть", "Один медиа-сервер", "Нету", "Есть"));
                    put("235", new Aircraft("Нет информации", "Один медиа-сервер", "Есть", "Нету"));
                    put("294", new Aircraft("Нет информации", "Один медиа-сервер", "Есть", "Есть"));
                    put("306", new Aircraft("Есть", "Один медиа-сервер", "Нету", "Есть"));
                    put("243", new Aircraft("Нет информации", "Один медиа-сервер", "Есть", "Нету"));
                    put("225", new Aircraft("Нет информации", "Один медиа-сервер", "Нету", "Есть"));
                    put("298", new Aircraft("Есть", "Один медиа-сервера", "Есть", "Есть"));
                    put("305", new Aircraft("Есть", "Один медиа-сервер", "Нету", "Есть"));
                    put("250", new Aircraft("Нету", "Один медиа-сервер", "Нету", "Есть"));
                    put("307", new Aircraft("Есть", "Один медиа-сервер", "Нету", "Есть"));
                    put("303", new Aircraft("Есть", "Один медиа-сервер", "Нету", "Есть"));
                    put("302", new Aircraft("Нет информации", "Один медиа-сервер", "Нету", "Есть"));
                    put("249", new Aircraft("Нету", "Один медиа-сервер", "Нету", "Есть"));
                    put("248", new Aircraft("Нет информации", "Один медиа-сервер", "Есть", "Нету"));
                    put("246", new Aircraft("Нет информации", "Нет медиа-сервера", "Нету", "Есть"));
                    put("245", new Aircraft("Есть", "Нет медиа-сервера", "Нету", "Есть"));
                    put("237", new Aircraft("Нету", "Нет медиа-сервера", "Есть", "Нету"));
                    put("358", new Aircraft("Нет информации", "Нет медиа-сервера", "Есть", "Нету"));
                    put("300", new Aircraft("Нет информации", "Нет медиа-сервера", "Есть", "Есть"));
                    put("293", new Aircraft("Есть","Нет информации","Есть","Есть"));


        }
    };

    @Override
    public String getBotUsername() {
        return "AircraftTelegramBot";
    }

    @Override
    public String getBotToken() {
        return "7672192413:AAEHzmg0BOXDEQJY2UMf0K2t0KgQSnQ3r28";
    }
    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText().trim();
            long chatId = update.getMessage().getChatId();
            if (messageText.equals("/start")){
                sendText(chatId, "Привет коллега!" + " \n(последние обновление производилось 27.03.2025)" );
            }

            if (messageText.matches("\\d{3}")) { // Проверка формата номера
                Aircraft aircraft = aircraftDB.get(messageText.toUpperCase());
                String response = (aircraft != null)
                        ? String.format("Информация о самолёте RA 73%s:\nПылесос: %s \nМедиа-сервер: %s \nПерегородка: %s \nPRAM: %s"+ " \nПриятного полёта и адекватных клиентов!",
                        messageText, aircraft.getVacuum(), aircraft.getMediaServer(), aircraft.getPartition(), aircraft.getPram())
                        : "Самолет с таким номером не найден в базе.";

                sendMessage(chatId, response);
            } else {
                sendMessage(chatId, "Пожалуйста, введите последние три цифры номера самолета в формате 123 (например, 303)");
            }
        }
    }

    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}