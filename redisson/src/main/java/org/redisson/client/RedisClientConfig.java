/**
 * Copyright 2016 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.client;

import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.redisson.config.SslProvider;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.Timer;
import org.redisson.misc.URIBuilder;

/**
 * 
 * @author Nikita Koksharov
 *
 */
public class RedisClientConfig {

    private URI address;
    
    private Timer timer;
    private ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    private EventLoopGroup group = new NioEventLoopGroup();
    private Class<? extends SocketChannel> socketChannelClass = NioSocketChannel.class;
    private int connectTimeout = 10000;
    private int commandTimeout = 10000;
    
    private String password;
    private int database;
    private String clientName;
    private boolean readOnly;
    private boolean keepPubSubOrder = true;
    private boolean pingConnection;
    private boolean keepAlive;
    private boolean tcpNoDelay;
    
    private boolean sslEnableEndpointIdentification = true;
    private SslProvider sslProvider = SslProvider.JDK;
    private URI sslTruststore;
    private String sslTruststorePassword;
    private URI sslKeystore;
    private String sslKeystorePassword;
    
    
    public RedisClientConfig setAddress(String host, int port) {
        this.address = URIBuilder.create("redis://" + host + ":" + port);
        return this;
    }
    public RedisClientConfig setAddress(String address) {
        this.address = URIBuilder.create(address);
        return this;
    }
    public RedisClientConfig setAddress(URI address) {
        this.address = address;
        return this;
    }
    public URI getAddress() {
        return address;
    }
    
    
    public Timer getTimer() {
        return timer;
    }
    public RedisClientConfig setTimer(Timer timer) {
        this.timer = timer;
        return this;
    }
    
    public ExecutorService getExecutor() {
        return executor;
    }
    public RedisClientConfig setExecutor(ExecutorService executor) {
        this.executor = executor;
        return this;
    }
    
    public EventLoopGroup getGroup() {
        return group;
    }
    public RedisClientConfig setGroup(EventLoopGroup group) {
        this.group = group;
        return this;
    }
    
    public Class<? extends SocketChannel> getSocketChannelClass() {
        return socketChannelClass;
    }
    public RedisClientConfig setSocketChannelClass(Class<? extends SocketChannel> socketChannelClass) {
        this.socketChannelClass = socketChannelClass;
        return this;
    }
    
    public int getConnectTimeout() {
        return connectTimeout;
    }
    public RedisClientConfig setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }
    
    public int getCommandTimeout() {
        return commandTimeout;
    }
    public RedisClientConfig setCommandTimeout(int commandTimeout) {
        this.commandTimeout = commandTimeout;
        return this;
    }
    
    public SslProvider getSslProvider() {
        return sslProvider;
    }
    public RedisClientConfig setSslProvider(SslProvider sslMode) {
        this.sslProvider = sslMode;
        return this;
    }
    
    public URI getSslTruststore() {
        return sslTruststore;
    }
    public RedisClientConfig setSslTruststore(URI sslTruststore) {
        this.sslTruststore = sslTruststore;
        return this;
    }
    
    public URI getSslKeystore() {
        return sslKeystore;
    }
    public RedisClientConfig setSslKeystore(URI sslKeystore) {
        this.sslKeystore = sslKeystore;
        return this;
    }
    
    public String getSslKeystorePassword() {
        return sslKeystorePassword;
    }
    public RedisClientConfig setSslKeystorePassword(String sslKeystorePassword) {
        this.sslKeystorePassword = sslKeystorePassword;
        return this;
    }

    public String getSslTruststorePassword() {
        return sslTruststorePassword;
    }
    public RedisClientConfig setSslTruststorePassword(String sslTruststorePassword) {
        this.sslTruststorePassword = sslTruststorePassword;
        return this;
    }
    
    public boolean isSslEnableEndpointIdentification() {
        return sslEnableEndpointIdentification;
    }
    public RedisClientConfig setSslEnableEndpointIdentification(boolean enableEndpointIdentification) {
        this.sslEnableEndpointIdentification = enableEndpointIdentification;
        return this;
    }

    public String getPassword() {
        return password;
    }
    public RedisClientConfig setPassword(String password) {
        this.password = password;
        return this;
    }
    
    public int getDatabase() {
        return database;
    }
    public RedisClientConfig setDatabase(int database) {
        this.database = database;
        return this;
    }
    
    public String getClientName() {
        return clientName;
    }
    public RedisClientConfig setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }
    
    public boolean isReadOnly() {
        return readOnly;
    }
    public RedisClientConfig setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    public boolean isKeepPubSubOrder() {
        return keepPubSubOrder;
    }
    public RedisClientConfig setKeepPubSubOrder(boolean keepPubSubOrder) {
        this.keepPubSubOrder = keepPubSubOrder;
        return this;
    }

    public boolean isPingConnection() {
        return pingConnection;
    }    
    public RedisClientConfig setPingConnection(boolean pingConnection) {
        this.pingConnection = pingConnection;
        return this;
    }
    
    public boolean isKeepAlive() {
        return keepAlive;
    }
    public RedisClientConfig setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
        return this;
    }

    public boolean isTcpNoDelay() {
        return tcpNoDelay;
    }
    public RedisClientConfig setTcpNoDelay(boolean tcpNoDelay) {
        this.tcpNoDelay = tcpNoDelay;
        return this;
    }
    
}
